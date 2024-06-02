package model.units

import controller.observers.ObserverAttack

import model.abilities.Ability
import scala.collection.mutable.ArrayBuffer

trait GameUnit {

  var cursedEnergy: Int
  var healthPoints: Int
  def name: String
  def maxCE: Int
  def maxHP: Int
  def attack: Int
  def technique: String

  def isAlive(): Boolean
  def canUseSpell(): Boolean
  def spells(): ArrayBuffer[Ability]
  def canUse(ability: Ability): Boolean

  def doAttack(target: GameUnit): Unit
  def useSpell(target: GameUnit, ability: Ability): Unit

  def registerAttackObserver(obs: ObserverAttack): Unit
}
