package controller.states.enemy

import controller.states.AbstractGameState
import controller.states.player
import controller.GameController
import model.units.GameUnit
import model.abilities.Ability

class FinalState(private val src: GameUnit, private val dest: GameUnit, private val sp: Option[Ability]) extends AbstractGameState {

  override def update(controller: GameController): Unit = {
  }
}
