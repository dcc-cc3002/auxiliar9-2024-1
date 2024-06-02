import controller.GameController

import view.ConsoleView

class BattleGame {
  private var controller: GameController = GameController()
  private var view: ConsoleView = ConsoleView()

  private var name: String = "Hola"

  def run() = {
    controller.startGame()
    while(!controller.finish()) {
      controller.handleInput()
      controller.update()
      view.render()
    }
  }


}
