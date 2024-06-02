package controller.states.enemy

import controller.states.AbstractGameState
import controller.states.GameState
import scala.util.Random
import model.units.GameUnit
import controller.GameController


class ActionState(private val source: GameUnit) extends AbstractGameState {
  private var selected: Option[GameState] = None
  // override def doAction(): Unit = {
  //   val option = if (controller.selected().canUseSpell()) random.nextBoolean() else true
  //   if (option) {
  //     controller.changeState(new TargetState(random))
  //   } else {
  //     controller.changeState(new SpellState(random))
  //   }
  // }
  override def handleInput(controller: GameController): Unit = {
    selected = Some(controller.getAIChoice(source))
  }

  override def update(controller: GameController): Unit = {
    controller.state = selected.get
  }
}
