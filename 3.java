class DNASequencer {

    StringBuilder dna;

    DNASequencer(int capacity) {
        dna = new StringBuilder(capacity);
    }

    public void ingestSequence(char[] sensorData) {

        for (int i = 0; i < sensorData.length; i++) {
            dna.append(sensorData[i]);
        }
    }

    public void mutateDNA(String target, String replacement) {

        int index = dna.indexOf(target);

        if (index != -1) {
            dna.replace(index,
                        index + target.length(),
                        replacement);
        }
    }

    public void printSequence() {
        System.out.println(dna.toString());
    }
}

class Main {

    public static void main(String[] args) {

        DNASequencer seq =
                new DNASequencer(100000);

        char[] data = {
                'A','C','G','T',
                'A','C','G','T',
                'A','C','G'
        };

        seq.ingestSequence(data);

        System.out.print("Original DNA: ");
        seq.printSequence();

        seq.mutateDNA("ACG", "TTT");

        System.out.print("Mutated DNA: ");
        seq.printSequence();
    }
}