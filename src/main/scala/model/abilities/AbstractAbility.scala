package model.abilities

import model.units.GameUnit

abstract class AbstractAbility(
    val cost: Int,
    val name: String,
    private val damage: Int
) extends Ability {

  def use(from: GameUnit, to: GameUnit): Unit = {
    from.cursedEnergy -= cost
    to.healthPoints -= damage
  }

}
