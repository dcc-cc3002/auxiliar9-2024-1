package controller.states.enemy

import controller.states.AbstractGameState
import controller.states.player
import controller.GameController
import model.units.GameUnit
import model.abilities.Ability

class FinalState(private val src: GameUnit, private val dest: GameUnit, private val sp: Option[Ability]) extends AbstractGameState {
  // override def doAction(): Unit = {
  //   if (controller.hasSpell()) {
  //     controller.useSpell()
  //   } else {
  //     controller.doAttack()
  //   }
  //   controller.changeState(new player.InitialState())
  // }

  override def update(controller: GameController): Unit = {
    if (sp.isDefined)
      src.useSpell(dest, sp.get)
    else
      src.doAttack(dest)

    controller.state = new player.InitialState()
  }
}
