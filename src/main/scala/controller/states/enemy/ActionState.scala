package controller.states.enemy

import controller.states.AbstractGameState
import scala.util.Random

class ActionState(private var random: Random) extends AbstractGameState {
  override def doAction(): Unit = {
    val option = if (controller.selected.canUseSpell()) random.nextBoolean() else true
    if (option) {
      controller.changeState(new TargetState(random))
    } else {
      controller.changeState(new SpellState(random))
    }
  }
}
