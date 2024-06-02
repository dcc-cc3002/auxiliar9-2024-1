package controller.states.enemy

import controller.states.AbstractGameState
import controller.states.player

class FinalState extends AbstractGameState {
  override def doAction(): Unit = {
    if (controller.hasSpell()) {
      controller.useSpell()
    } else {
      controller.doAttack()
    }
    controller.changeState(new player.InitialState())
  }
}
