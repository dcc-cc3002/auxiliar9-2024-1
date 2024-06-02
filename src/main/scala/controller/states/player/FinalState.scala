package controller.states.player

import controller.states.AbstractGameState
import controller.states.enemy
import model.units.GameUnit
import model.abilities.Ability
import controller.GameController

class FinalState(private val source: GameUnit, private val target: GameUnit, private val spell: Option[Ability]) extends AbstractGameState {
  override def update(controller: GameController): Unit = {
  }
}
