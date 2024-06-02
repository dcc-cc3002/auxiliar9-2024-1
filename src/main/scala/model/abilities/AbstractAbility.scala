package model.abilities

import model.units.GameUnit

abstract class AbstractAbility(
    val cost: Int,
    val name: String,
    private val damage: Int
) extends Ability {

  override def use(from: GameUnit, to: GameUnit): Int = {
    from.cursedEnergy -= cost
    to.healthPoints -= damage
    damage
  }

}
