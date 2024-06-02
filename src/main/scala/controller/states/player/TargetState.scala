package controller.states.player

import model.units.GameUnit
import controller.states.AbstractGameState
import controller.GameController
import view.GameView
import model.abilities.Ability


class TargetState(private val source: GameUnit, private val spell: Option[Ability]) extends AbstractGameState {
  private var selected: Option[GameUnit] = None

  def this(source: GameUnit) = {
    this(source, None)
  }

  override def notify(controller: GameController) = {
    controller.notifyPlayerTarget()
  }

  override def handleInput(controller: GameController): Unit = {
    val choice = controller.getNumericalInput()
    try {
      selected = Some(controller.getEnemy(choice - 1))
    } catch {
      case e: IndexOutOfBoundsException => controller.notifyErrorInvalidOption(choice)
    }
  }

  override def update(controller: GameController): Unit = {
    if (selected.isDefined)
      controller.state = new FinalState(source, selected.get, spell)
  }
  // override def doAction(): Unit = {
  //   controller.promptEnemies()
  //   val id: Int = controller.getInput()
  //   if (0 < id && id <= controller.enemiesLength()) {
  //     controller.selectAllyTarget(id-1)
  //     controller.changeState(new FinalState())
  //   } else {
  //     controller.promptError(id)
  //   }
  // }
}
