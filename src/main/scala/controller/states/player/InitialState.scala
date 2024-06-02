package controller.states.player

import controller.states.AbstractGameState

import view.GameView
import controller.GameController

class InitialState extends AbstractGameState {

  override def handleInput(controller: GameController): Unit = {}

  override def update(controller: GameController) = {
    controller.state = new UnitState()
  }

  override def notify(controller: GameController): Unit = {
    controller.notifyPlayerStart()
  }
}

