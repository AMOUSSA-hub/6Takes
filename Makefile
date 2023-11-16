# COMMANDES #
JAVAC = javac
# note $$ to get a single shell $
JAVAC_OPTIONS = -d build  -sourcepath src   -encoding UTF-8 -implicit:none
JAVA = java
JAVA_OPTIONS_W = -cp build 
JAVA_OPTIONS = -cp build 
JAR = jar
EXEC_JAR = ${JAVA} -jar
SUP = rm -rf

# CHEMINS RELATIFS
SRC = src/fr/amoussa/SixTakes
BUILD = build/fr/amoussa/SixTakes
DOC = doc/fr/amoussa/SixTakes
BUILD_WINDOWS = "build/fr/amoussa/SixTakes/"
# CHOIX NOMS
JAR_FILE =  6Takes.jar


# BUT PAR DEFAUT #
run : ${BUILD}/App.class
	${JAVA} ${JAVA_OPTIONS} fr.amoussa.SixTakes.App

run_W :${BUILD}/App.class
	${JAVA} ${JAVA_OPTIONS_W} fr.amoussa.SixTakes.App

jar:${JAR_FILE}
	${EXEC_JAR} ${JAR_FILE}

# POUR WINDOWS#
clean_W : 
	rd /s /q ${BUILD_WINDOWS}

clean_jar_W:
	del 6Takes.jar

#POUR LINUX 
clean : 
	rm -r build/*

clean_jar:
	rm 6Takes.jar
	
# REGLES DE DEPENDANCE #

${BUILD}/App.class:  ${SRC}/App.java \
	${BUILD}/View/Acceuil.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/App.java

# CLASSES VIEW#

${BUILD}/View/Acceuil.class:  ${SRC}/View/Accueil.java \
	${BUILD}/Controller/AcceuilListener.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/View/Accueil.java

${BUILD}/View/Gamefen.class:  ${SRC}/View/Gamefen.java \
	${BUILD}/View/FormNumberPlayer.class \
	${BUILD}/View/GameBoard.class \
	${BUILD}/Model/Game.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/View/Gamefen.java

${BUILD}/View/FormNumberPlayer.class: ${SRC}/View/FormNumberPlayer.java 
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/View/FormNumberPlayer.java

${BUILD}/View/GameBoard.class: ${SRC}/View/GameBoard.java \
	${BUILD}/View/Card.class \
	${BUILD}/Controller/CardHandListener.class \
	${BUILD}/Controller/FoldListener.class \
	${BUILD}/View/Fold.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/View/GameBoard.java

${BUILD}/View/Card.class: ${SRC}/View/Card.java \
	${BUILD}/Utils/Icone.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/View/Card.java	


${BUILD}/View/Fold.class:  ${SRC}/View/Fold.java
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/View/Fold.java


# CLASSES CONTROLLER#

${BUILD}/Controller/AcceuilListener.class:  ${SRC}/Controller/AccueilListener.java \
	${BUILD}/View/Gamefen.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Controller/AccueilListener.java


${BUILD}/Controller/CardHandListener.class: ${SRC}/Controller/CardHandListener.java
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Controller/CardHandListener.java


${BUILD}/Controller/FoldListener.class: ${SRC}/Controller/FoldListener.java
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Controller/FoldListener.java
# CLASSES MODEL#

${BUILD}/Model/Game.class:  ${SRC}/Model/Game.java \
	${BUILD}/Model/Player.class \
	${BUILD}/Model/FoldModel.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Model/Game.java

${BUILD}/Model/FoldModel.class:  ${SRC}/Model/FoldModel.java
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Model/FoldModel.java


${BUILD}/Model/Player.class:  ${SRC}/Model/Player.java
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Model/Player.java

# CLASSES MODEL#



${BUILD}/Utils/Icone.class:  ${SRC}/Utils/Icone.java
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Utils/Icone.java


# ## JARS ##

 ${JAR_FILE} : ${BUILD}/App.class
	${JAR} cvfe ${JAR_FILE}  fr.amoussa.SixTakes.App -C build .  -C res .