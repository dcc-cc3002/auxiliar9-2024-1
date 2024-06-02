package controller.states.enemy

import controller.states.AbstractGameState
import scala.util.Random

class TargetState(private var random: Random) extends AbstractGameState {
  override def doAction(): Unit = {
    val id = random.nextInt(controller.alliesLength())
    controller.selectEnemyTarget(id)
    controller.changeState(new FinalState())
  }
}
