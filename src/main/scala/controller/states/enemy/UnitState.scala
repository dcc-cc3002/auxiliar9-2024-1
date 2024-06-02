package controller.states.enemy

import controller.states.AbstractGameState
import controller.GameController
import model.units.GameUnit

class UnitState extends AbstractGameState {
  private var selected: Option[GameUnit] = None

  // override def doAction(): Unit = {
  //   val random = new Random()
  //   var id = random.nextInt(controller.enemiesLength())
  //   controller.selectEnemy(id)
  //   while(!controller.selected().isAlive()) {
  //     id = random.nextInt(controller.enemiesLength())
  //     controller.selectEnemy(id)
  //   }
  //   controller.changeState(new ActionState(random))
  // }
  //
  override def notify(controller: GameController): Unit = {
    controller.notifyEnemyStart()
  }

  override def handleInput(controller: GameController): Unit = {
    selected = Some(controller.getAIUnit())
  }

  override def update(controller: GameController): Unit = {
    if (selected.isDefined)
      controller.state = new ActionState(selected.get)
  }
} 
