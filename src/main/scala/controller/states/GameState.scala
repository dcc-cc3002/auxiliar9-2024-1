package controller.states

import view.GameView

import controller.GameController

trait GameState {
  def notify(controller: GameController): Unit
  def handleInput(controller: GameController): Unit
  def update(controller: GameController): Unit
}   
