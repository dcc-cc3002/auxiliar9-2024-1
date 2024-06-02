package controller.states

import controller.observers.Observer
import controller.GameController

trait GameState {
  var controller: GameController
  def doAction(): Unit
}   
