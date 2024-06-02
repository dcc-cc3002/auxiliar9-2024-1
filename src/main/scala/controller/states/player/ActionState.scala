package controller.states.player

import controller.GameController
import controller.states.AbstractGameState
import model.units.GameUnit
import controller.states.GameState

class ActionState(private val ally: GameUnit) extends AbstractGameState {
  private var selected: Option[GameState] = None

  override def notify(controller: GameController): Unit = {
    controller.notifyPlayerAction()
  }

  override def handleInput(controller: GameController): Unit = {
    val choice = controller.getNumericalInput()
    choice match {
      case 0 => selected = Some(new UnitState())
      case 1 => selected = Some(new TargetState(ally))
      case 2 => selected = Some(new SpellState(ally))
      case _ => controller.notifyErrorInvalidOption(choice)
    }
  }

  override def update(controller: GameController): Unit = {
    if (selected.isDefined)
      controller.state = selected.get
  }

  // override def doAction(): Unit = {
  //   controller.promptActions()
  //   val id: Int = controller.getInput() 
  //   id match {
  //     case 0 => controller.changeState(new UnitState())
  //     case 1 => controller.changeState(new TargetState())
  //     case 2 => 
  //     {
  //       if (controller.selected().canUseSpell())
  //         controller.changeState(new SpellState())
  //       else
  //         controller.promptNoEnergy()
  //     }
  //     case _ => controller.promptError(id)
  //   }
  // }
}
