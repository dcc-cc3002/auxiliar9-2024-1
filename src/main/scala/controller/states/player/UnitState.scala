package controller.states.player

import controller.states.AbstractGameState
import controller.GameController
import view.GameView
import model.units.GameUnit

class UnitState extends AbstractGameState {
  // override def doAction() = {
  //   controller.promptAllies()
  //   val id = controller.getInput()
  //   if (0 < id && id <= controller.alliesLength()) {
  //     controller.selectAlly(id-1)
  //     controller.changeState(new ActionState())
  //   } else {
  //     controller.promptError(id)
  //   }
  // }
  private var selected: Option[GameUnit] = None
  

  override def notify(controller: GameController): Unit = {
    controller.notifyPlayerUnits()
  }

  override def handleInput(controller: GameController): Unit = {
    val choice = controller.getNumericalInput()
    try {
      selected = Some(controller.getAlly(choice - 1))
    } catch {
      case e: IndexOutOfBoundsException => controller.notifyErrorInvalidOption(choice)
    }
  }

  override def update(controller: GameController): Unit = {
    if (selected.isDefined)
      controller.state = new ActionState(selected.get)
  }
}
