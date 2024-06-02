package model.abilities

import model.units.GameUnit

trait Ability {
  def cost: Int
  def name: String
  def use(from: GameUnit, to: GameUnit): Unit
}
