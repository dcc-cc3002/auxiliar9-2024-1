package controller.states.player

import model.units.GameUnit
import controller.states.AbstractGameState
import controller.GameController
import model.abilities.Ability

class SpellState(private val src: GameUnit) extends AbstractGameState {
  // override def doAction(): Unit = {
  //   val spells = controller.selected().spells()
  //   controller.promptSpells(spells)
  //   val id = controller.getInput()
  //   if (0 < id && id <= spells.length) {
  //     val sp = spells(id-1)
  //     if (controller.selected().canUse(sp))
  //     {
  //       controller.spell = spells(id-1)
  //       controller.changeState(new TargetState())
  //     } else {
  //       controller.promptNoEnergy()
  //     }
  //   } else {
  //     controller.promptError(id)
  //   }
  // }
  private var selected: Option[Ability] = None

  override def notify(controller: GameController) = {
    controller.notifyPlayerUnitSpells(src)
  }

  override def handleInput(controller: GameController): Unit = {
    val choice = controller.getNumericalInput()
    try {
      val spell = src.spells()(choice - 1)
      if (src.canUse(spell))
        selected = Some(spell)
      else
        controller.notifyErrorNoEnergy()
    } catch {
      case e: IndexOutOfBoundsException => controller.notifyErrorInvalidOption(choice)
    }
  }

  override def update(controller: GameController): Unit = {
    if (selected.isDefined)
      controller.state = new TargetState(src, selected)
  }
}
