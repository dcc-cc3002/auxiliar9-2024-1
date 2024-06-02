package controller.states.player

import controller.states.AbstractGameState

class InitialState extends AbstractGameState {

  override def doAction(): Unit = {
    controller.promptStart()
    controller.changeState(new UnitState())
  }

}
