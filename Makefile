SRC = src/program/Train.java src/program/PlotExample.java src/program/Predict.java
CLASS = $(SRC:.java=.class)

all: $(CLASS)

$(CLASS): $(SRC)
	@javac $(SRC)
	@echo 'Usage:'
	@echo 'make train'
	@echo 'make predict'


clean:
	@rm -f src/program/*.class thetas.txt

predict: all
	@java -cp src program.Predict

train: all
	@java -cp src program.Train data.csv

re: clean all
