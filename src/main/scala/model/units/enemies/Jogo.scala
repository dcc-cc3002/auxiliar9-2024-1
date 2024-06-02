package model.units.enemies

import model.units.AbstractGameUnit
import model.abilities.enemies.Flames
import model.abilities.enemies.Meteor

class Jogo extends AbstractGameUnit("Jogo", 20, 100, 100) {
  addSpell(new Flames)
  addSpell(new Meteor)

  def technique: String = "Fire manipulation"
}
