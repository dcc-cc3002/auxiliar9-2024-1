package model

import model.units.GameUnit
import model.units.allies._
import model.units.enemies._
import model.abilities.Ability

import scala.collection.mutable.ArrayBuffer
import controller.GameController
import view.GameView

class GameModel {
  private val _allies = ArrayBuffer.empty[GameUnit]
  private val _enemies = ArrayBuffer.empty[GameUnit]

  def init(controller: GameController): Unit = {
    val gojo = new GojoSatoru()
    val yuji = new ItadoriYuji()
    controller.registerUnit(gojo)
    controller.registerUnit(yuji)
    _allies += gojo
    _allies += yuji

    val jogo = new Jogo()
    val mahito = new Mahito()
    controller.registerUnit(jogo)
    controller.registerUnit(mahito)
    _enemies += jogo
    _enemies += mahito
  }

  def allies = _allies
  def enemies = _enemies

  def enemiesAlive(): Boolean = {
    var alive = false
    for (u <- enemies) {
      alive ||= u.isAlive()
    }
    alive
  }

  def alliesAlive(): Boolean = {
    var alive = false
    for (u <- allies) {
      alive ||= u.isAlive()
    }
    alive
  }

}
