package view

import controller.observers._

import scala.io.StdIn
import scala.collection.mutable.Queue
import scala.collection.mutable.ArrayBuffer
import model.units.GameUnit
import model.abilities.Ability

class GameView {
  private val queue = new Queue[String].empty

  def getNumericalInput(): Int = {
    val resp = StdIn.readLine()
    resp.toInt
  }

  def displayInitMessage(): Unit = {
    queue.enqueue("Bienvenido al combate!")
  }

  def displayPlayerStart(): Unit = {
    queue.enqueue("Turno del jugador")
  }

  def displayEnemyStart(): Unit = {
    queue.enqueue("Turno del enemigo")
  }

  def displayPlayerUnits(allies: ArrayBuffer[GameUnit]): Unit = {
    queue.enqueue("Escoge un aliado:")
    for(i <- allies.indices) {
      queue.enqueue(s"${i+1}) ${allies(i).name}")
    }
  }


  def displayPlayerAction(): Unit = {
    queue.enqueue("Escoge una acción:")
    queue.enqueue("1) Atacar")
    queue.enqueue("2) Usar técnica maldita")
    queue.enqueue("0) Cambiar de aliado")

  }

  def displayPlayerTarget(enemies: ArrayBuffer[GameUnit]): Unit = {
    queue.enqueue("Escoge un enemigo:")
    for(i <- enemies.indices) {
      queue.enqueue(s"${i+1}) ${enemies(i).name} ${enemies(i).healthPoints}/${enemies(i).maxHP} PV")
    }
  }

  def displayPlayerUnitSpells(spells: ArrayBuffer[Ability]): Unit = {
    queue.enqueue("Escoge un hechizo:")
    for(i <- spells.indices) {
      queue.enqueue(s"${i+1}) ${spells(i).name} ${spells(i).cost} EM")
    }
  }

  def displayUnitInfo(gUnit: GameUnit): Unit = {
    queue.enqueue(s"Estado de ${gUnit.name}")
    queue.enqueue(s"PV: ${gUnit.healthPoints}/${gUnit.maxHP}")
    queue.enqueue(s"EM: ${gUnit.cursedEnergy}/${gUnit.maxCE}")
    queue.enqueue(s"Técnica maldita: ${gUnit.technique}")
  }

  def displaySimpleAttack(src: GameUnit, dest: GameUnit, amount: Int): Unit = {
    queue.enqueue(s"${src.name} ataca ${dest.name}")
    queue.enqueue(s"${src.name} hizo ${amount} de daño!")
    queue.enqueue(s"PV de ${dest.name} reducidos a ${dest.healthPoints}")
  }

  def displaySpellAttack(src: GameUnit, dest: GameUnit, sp: Ability, amount: Int): Unit = {
    queue.enqueue(s"${src.name} usa ${sp.name} contra ${dest.name}")
    queue.enqueue(s"${sp.name} hizo ${amount} de daño!")
    queue.enqueue(s"PV de ${dest.name} reducidos a ${dest.healthPoints}")
    queue.enqueue(s"EM de ${src.name} reducidos a ${src.cursedEnergy}")
  }

  def displayVictory(): Unit = {
    queue.enqueue("Felicidades! Ganaste!")
  }

  def displayDefeat(): Unit = {
    queue.enqueue("O no! Perdiste :c")
  }

  def displayErrorNoEnergy(): Unit = {
    queue.enqueue("No tienes suficiente energía maldita")
  }

  def displayErrorInvalidOption(choice: Int): Unit = {
    queue.enqueue(s"Opción inválida ${choice}")
  }

  def render(): Unit = {
    // Usamos algo clásico en el desarrollo de juegos
    // que es acumular el rendering en una cola
    // esto permite poder decidie en que orden
    // hacer cada render, cosa que aqui no es
    // necesario, pero es un buen dato :)
    
    while (!queue.isEmpty) {
      println(queue.dequeue())
    }
  }

}
