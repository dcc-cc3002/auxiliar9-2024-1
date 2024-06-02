package controller.states.player

import controller.states.AbstractGameState
import controller.states.enemy

class FinalState extends AbstractGameState {
  override def doAction(): Unit = {
    if (controller.hasSpell()) {
      controller.useSpell()
    }  else {
      controller.doAttack()
    } 
    controller.changeState(new enemy.UnitState())
  }
}
