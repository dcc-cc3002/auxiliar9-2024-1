package controller.states.enemy


import controller.states.AbstractGameState
import model.units.GameUnit
import controller.GameController
import model.abilities.Ability

class SpellState(private var source: GameUnit) extends AbstractGameState {
  // override def doAction(): Unit = {
  //   val spells = controller.selected().spells()
  //   val id = random.nextInt(spells.length)
  //   while(!controller.selected().canUse(spells(id))) {
  //     val id = random.nextInt(spells.length)
  //   }
  //   controller.spell = spells(id)
  //   controller.changeState(new TargetState(random))
  // }
  private var selected: Option[Ability] = None

  override def handleInput(controller: GameController): Unit = {
    selected = Some(controller.getAISpell(source))
  }

  override def update(controller: GameController): Unit = {
    if (selected.isDefined)
      controller.state = new TargetState(source, selected)
  }
}

