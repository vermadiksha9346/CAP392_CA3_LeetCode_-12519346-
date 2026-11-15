class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int j = i + 1;
            int lineLength = words[i].length();

            while (j < words.length && lineLength + 1 + words[j].length() <= maxWidth) {
                lineLength += 1 + words[j].length();
                j++;
            }

            int diff = j - i;
            int numberOfWords = diff;
            StringBuilder line = new StringBuilder();

            if (j == words.length || numberOfWords == 1) {
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) {
                        line.append(" ");
                    }
                }
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } else {
                int totalSpaces = maxWidth - (lineLength - (numberOfWords - 1));
                int spacesBetween = totalSpaces / (numberOfWords - 1);
                int extraSpaces = totalSpaces % (numberOfWords - 1);

                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) {
                        int spacesToApply = spacesBetween + (extraSpaces > 0 ? 1 : 0);
                        extraSpaces--;
                        for (int s = 0; s < spacesToApply; s++) {
                            line.append(" ");
                        }
                    }
                }
            }

            result.add(line.toString());
            i = j;
        }

        return result;
    }
}
