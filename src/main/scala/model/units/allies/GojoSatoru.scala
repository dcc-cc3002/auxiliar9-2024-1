package model.units.allies

import model.units.AbstractGameUnit
import model.abilities.allies.Blue
import model.abilities.allies.Red
import model.abilities.allies.Purple

class GojoSatoru extends AbstractGameUnit("Satoru Gojo", 20, 100, 150) {
  addSpell(new Blue)
  addSpell(new Red)
  addSpell(new Purple)

  def technique: String = "No technique"
}
