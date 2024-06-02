package controller


import view.GameView
import model.GameModel
import states.GameState
import states.player.InitialState
import observers._
import model.units.GameUnit
import model.units.enemies._
import model.units.allies._
import model.abilities.Ability
import scala.collection.mutable.ArrayBuffer
import scala.compiletime.unitialized
import scala.util.Random

class GameController(private val model: GameModel, private val view: GameView) {
  private var _state: GameState = unitialized
  private val ai = new Random()
  private val attackObs = new ArrayBuffer[ObserverAttack].empty
  init()

  private def init(): Unit = {
    notifyInitMessage()
    attackObs += new ObserverAttack(view)
    model.init(this)
    state = new InitialState()
  }

  private def checkFinished(): Unit = {
    if (win()) {
      view.displayVictory()
    } else if (lose()) {
      view.displayDefeat()
    }
  }

  /* Empieza todo lo que hay que añadir */

  def hasFinished(): Boolean = { }

  def handleInput(): Unit = { }

  def update(): Unit = { }

  def state: GameState = { }
  def state_=(other: GameState): Unit = { }

  def getNumericalInput(): Int = { }

  def getAlly(choice: Int): GameUnit = { }

  def getEnemy(choice: Int): GameUnit = { }

  def win(): Boolean = { }

  def lose(): Boolean = { }

  def registerUnit(gUnit: GameUnit) = { }


  /* parte 2 */
  
  def getAIUnit(): GameUnit = { }

  def getAIChoice(u: GameUnit): GameState = { }

  def getAITarget(): GameUnit = { }

  def getAISpell(u: GameUnit): Ability = { }
  
  /* Aqui termina */

  def notifyInitMessage() = {
    view.displayInitMessage()
  }

  def notifyPlayerStart() = {
    view.displayPlayerStart()
  }

  def notifyEnemyStart() = {
    view.displayEnemyStart()
  }

  def notifyPlayerUnits() = {
    view.displayPlayerUnits(model.allies)
  }

  def notifyPlayerAction() = {
    view.displayPlayerAction()
  }

  def notifyPlayerTarget() = {
    view.displayPlayerTarget(model.enemies)
  }

  def notifyPlayerUnitSpells(pUnit: GameUnit) = {
    view.displayPlayerUnitSpells(pUnit.spells())
  }

  def notifyAllyChoose(pUnit: GameUnit) = {
    view.displayUnitInfo(pUnit)
  }

  def notifyErrorNoEnergy() = {
    view.displayErrorNoEnergy()
  }

  def notifyErrorInvalidOption(choice: Int) = {
    view.displayErrorInvalidOption(choice)
  }
}
