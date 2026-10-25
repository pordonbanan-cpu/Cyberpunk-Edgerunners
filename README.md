# Cyberpunk: Edgerunners (NeoForge 1.21.1)

Мод с Сэндевистаном для Minecraft **1.21.1** + **NeoForge**.

## Готовый JAR

После пуша в `main` GitHub Actions соберёт JAR:

**Actions → Build Mod JAR → Artifacts → edgerunners-jar**

Локально (JDK 21, лучше от 2 ГБ RAM):

```bash
./gradlew build
# JAR: build/libs/edgerunners-0.2.0.jar
```

## В игре

1. Установи NeoForge 1.21.1
2. Положи JAR в папку `mods/`
3. Креатив → вкладка **Cyberpunk: Edgerunners** → Сэндевистан
4. ПКМ — надеть / активировать; клавиша **V** (настраивается)

## Содержимое

- Предмет «Сэндевистан» (слот нагрудника)
- Эффекты: Сэндевистан + Замедление времени
- Модель на спине игрока + афтеимиджи
- Исходник Blockbench: `blockbench/sandevistan.bbmodel`
