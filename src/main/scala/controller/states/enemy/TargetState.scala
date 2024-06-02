package controller.states.enemy

import controller.states.AbstractGameState
import model.units.GameUnit
import model.abilities.Ability
import controller.GameController

class TargetState(private val source: GameUnit, private val spell: Option[Ability]) extends AbstractGameState {
  private var selected: Option[GameUnit] = None

  def this(source: GameUnit) = {
    this(source, None)
  }

  override def handleInput(controller: GameController): Unit = {
    selected = Some(controller.getAITarget())
  }

  override def update(controller: GameController): Unit = {
    if (selected.isDefined)
      controller.state = new FinalState(source, selected.get, spell)
  }

  // override def doAction(): Unit = {
  //   val id = random.nextInt(controller.alliesLength())
  //   controller.selectEnemyTarget(id)
  //   controller.changeState(new FinalState())
  // }


}
