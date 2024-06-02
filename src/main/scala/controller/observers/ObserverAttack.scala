package controller.observers

import view.GameView

import model.units.GameUnit
import model.abilities.Ability

class ObserverAttack(private val view: GameView) {

  def notifySimpleAttack(src: GameUnit, dest: GameUnit, dmg: Int) = {
    view.displaySimpleAttack(src, dest, dmg)
  }
  
  def notifySpellAttack(src: GameUnit, dest: GameUnit, sp: Ability, dmg: Int) = {
    view.displaySpellAttack(src, dest, sp, dmg)
  }

}
