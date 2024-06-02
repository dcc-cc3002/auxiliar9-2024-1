package model.units.allies

import model.units.AbstractGameUnit
import model.abilities.allies.Basic

class ItadoriYuji extends AbstractGameUnit("Yuji Itadori", 30, 150, 60) {
  addSpell(new Basic)

  def technique: String = "No technique"
}
