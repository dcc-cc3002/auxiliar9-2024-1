import controller.GameController
import model.GameModel
import view.GameView

class BattleGame {

  def run() = {
    val controller: GameController = new GameController(new GameModel, new GameView)
    while(!controller.hasFinished()) {
      controller.handleInput()
      controller.update()
    }
  }


}
