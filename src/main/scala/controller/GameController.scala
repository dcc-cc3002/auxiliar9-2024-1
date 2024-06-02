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
import scala.compiletime.uninitialized
import scala.util.Random
import controller.states.enemy.TargetState
import controller.states.enemy.SpellState

class GameController(private val model: GameModel, private val view: GameView) {

  private var _state: GameState = uninitialized
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

  def hasFinished(): Boolean = {
    win() || lose()
  }

  def handleInput(): Unit = {
    state.handleInput(this)
  }

  def update(): Unit = {
    state.update(this)
    checkFinished()
    view.render()
  }

  def state: GameState = _state
  def state_=(other: GameState): Unit = {
    _state =  other
    _state.notify(this)
  }

  def getNumericalInput(): Int = {
    view.getNumericalInput()
  }

  def getAlly(choice: Int): GameUnit = {
    val u = model.allies(choice)
    notifyAllyChoose(u)
    u
  }

  def getEnemy(choice: Int): GameUnit = {
    val u = model.enemies(choice)
    u
  }

  def getAIUnit(): GameUnit = {
    var choice = ai.nextInt(model.enemies.length)
    while(!model.enemies(choice).isAlive()) {
      choice = ai.nextInt(model.enemies.length)
    }
    model.enemies(choice)
  }

  def getAIChoice(u: GameUnit): GameState = {
    var useSpell = u.canUseSpell() && ai.nextBoolean()
    if (useSpell) {
      new SpellState(u)
    } else {
      new TargetState(u)
    }
  }

  def getAITarget(): GameUnit = {
    var choice = ai.nextInt(model.allies.length)
    while(!model.allies(choice).isAlive()) {
      choice = ai.nextInt(model.allies.length)
    }
    model.allies(choice)
  }

  def getAISpell(u: GameUnit): Ability = {
    val spells = u.spells()
    var choice = ai.nextInt(spells.length)
    while(!u.canUse(spells(choice))) {
      choice = ai.nextInt(spells.length)
    }
    spells(choice)
  }

  def registerUnit(gUnit: GameUnit) = {
    for (o <- attackObs) {
      gUnit.registerAttackObserver(o)
    }
  }

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


  def win(): Boolean = {
    !model.enemiesAlive()
  }

  def lose(): Boolean = {
    !model.alliesAlive()
  }

}
