import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> course = Arrays.stream(scanner.nextLine().split(", ")).map(String::valueOf).collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("course start")) {
            List<String> cmd = Arrays.stream(input.split(":")).map(String::valueOf).collect(Collectors.toList());
            String lesson = cmd.get(1);
            switch (cmd.get(0)) {
                case "Add":
                    addLesson(course, lesson);
                    break;
                case "Insert":
                    int index = Integer.parseInt(cmd.get(2));
                    insertLesson(course, lesson, index);
                    break;
                case "Remove":
                    removeLesson(course, lesson);
                    break;
                case "Swap":
                    String secondLesson = cmd.get(2);
                    swapLesson(course, lesson, secondLesson);
                    break;
                case "Exercise":
                    addExercise(course, lesson);
                    break;
                default:
                    break;
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < course.size(); i++) {
            System.out.printf("%d.%s%n", i + 1, course.get(i));
        }
    }

    private static void addLesson(List<String> list, String lesson) {
        if (!list.contains(lesson)) {
            list.add(lesson);
        }
    }

    private static void insertLesson(List<String> list, String lesson, int index) {
        if (!list.contains(lesson)) {
            if (index >= 0 && index < list.size()) {
                list.add(index, lesson);
            }
        }
    }

    private static void removeLesson(List<String> list, String lesson) {
        if (list.contains(lesson)) {
            list.remove(lesson);
        } else if (list.contains(lesson + "-Exercise")) {
            list.remove(lesson);
        }
    }

    private static void swapLesson(List<String> list, String lesson1, String lesson2) {
        int index1 = list.indexOf(lesson1);
        int index2 = list.indexOf(lesson2);
        if (list.contains(lesson1) && list.contains(lesson2)) {
            list.set(index1, lesson2);
            list.set(index2, lesson1);
            if (list.contains(lesson1 + "-Exercise")) {
                index1 = list.indexOf(lesson1);
                list.remove(lesson1 + "-Exercise");
                list.add(index1 + 1, lesson1 + "-Exercise");
            } else if (list.contains(lesson2 + "-Exercise")) {
                index2 = list.indexOf(lesson2);
                list.remove(lesson2 + "-Exercise");
                list.add(index2 + 1, lesson2 + "-Exercise");
            }
        }
    }

    private static void addExercise(List<String> list, String lesson) {
        if (list.contains(lesson) && !list.contains(lesson + "-Exercise")) {
            int index = list.indexOf(lesson);
            list.add(index + 1, lesson + "-Exercise");
        } else if (!list.contains(lesson)) {
            addLesson(list, lesson);
            addLesson(list, lesson + "-Exercise");
        }
    }
}
