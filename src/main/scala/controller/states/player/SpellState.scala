package controller.states.player

import model.units.GameUnit
import controller.states.AbstractGameState
import controller.GameController
import model.abilities.Ability

class SpellState(private val src: GameUnit) extends AbstractGameState {
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
