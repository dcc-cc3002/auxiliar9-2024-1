package controller.states.enemy

import controller.states.AbstractGameState
import controller.states.GameState
import scala.util.Random
import model.units.GameUnit
import controller.GameController


class ActionState(private val source: GameUnit) extends AbstractGameState {
  private var selected: Option[GameState] = None

  override def handleInput(controller: GameController): Unit = {
    selected = Some(controller.getAIChoice(source))
  }

  override def update(controller: GameController): Unit = {
    controller.state = selected.get
  }
}
