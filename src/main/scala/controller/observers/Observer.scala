package controller.observers

import model.abilities.Ability
import model.units.GameUnit

trait Observer {
  def updateAttack(from: GameUnit, to: GameUnit): Unit
  def updateSpell(from: GameUnit, to: GameUnit, sp: Ability): Unit
}
