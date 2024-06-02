package controller.states.enemy


import controller.states.AbstractGameState
import model.units.GameUnit
import controller.GameController
import model.abilities.Ability

class SpellState(private var source: GameUnit) extends AbstractGameState {
  private var selected: Option[Ability] = None

  override def handleInput(controller: GameController): Unit = {
    selected = Some(controller.getAISpell(source))
  }

  override def update(controller: GameController): Unit = {
    if (selected.isDefined)
      controller.state = new TargetState(source, selected)
  }
}

