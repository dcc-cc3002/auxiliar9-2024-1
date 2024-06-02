package model.units.enemies

import model.units.AbstractGameUnit
import model.abilities.enemies.Transfiguration

class Mahito extends AbstractGameUnit("Mahito", 10, 80, 120) {
  addSpell(new Transfiguration)

  def technique: String = "Soul Manipulation"
}
