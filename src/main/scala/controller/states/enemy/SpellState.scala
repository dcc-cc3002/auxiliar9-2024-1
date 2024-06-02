package controller.states.enemy


import controller.states.AbstractGameState
import scala.util.Random

class SpellState(private var random: Random) extends AbstractGameState {
  override def doAction(): Unit = {
    val spells = controller.selected.spells()
    val id = random.nextInt(spells.length)
    while(!controller.selected.canUse(spells(id))) {
      val id = random.nextInt(spells.length)
    }
    controller.spell = spells(id)
    controller.changeState(new TargetState(random))
  }
}

