PROBLEM  1: 


import java.util.Scanner;

public class SortingAlgorithms {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();

        int[] array = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("Choose the sorting algorithm:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Selection Sort");
        System.out.println("3. Merge Sort");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                bubbleSort(array);
                System.out.println("Sorted array using Bubble Sort:");
                break;
            case 2:
                selectionSort(array);
                System.out.println("Sorted array using Selection Sort:");
                break;
            case 3:
                mergeSort(array, 0, array.length - 1);
                System.out.println("Sorted array using Merge Sort:");
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }

        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = array[minIdx];
            array[minIdx] = array[i];
            array[i] = temp;
        }
    }
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }
   public static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int i = 0; i < n2; i++) {
            rightArray[i] = array[mid + 1 + i];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
 }
}
}





PROBLEM 2

  
import java.util.Scanner;
public class MatrixMultiplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Number of rows and columns for Matrix A:");
        int aRows = scanner.nextInt();
        int aCols = scanner.nextInt();
        
        int[][] matrixA = new int[aRows][aCols];
        System.out.println("Elements of Matrix A:");
        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < aCols; j++) {
                matrixA[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Enter the number of rows and columns for Matrix B:");
        int bRows = scanner.nextInt();
        int bCols = scanner.nextInt();
        
        
        if (aCols != bRows) {
            System.out.println("Matrix multiplication error");
            return;
        }
        int[][] matrixB = new int[bRows][bCols];
        System.out.println("elements of Matrix B:");
        for (int i = 0; i < bRows; i++) {
            for (int j = 0; j < bCols; j++) {
                matrixB[i][j] = scanner.nextInt();
            }
        }
        int[][] resultMatrix = new int[aRows][bCols];
        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bCols; j++) {
                resultMatrix[i][j] = 0;
                for (int k = 0; k < aCols; k++) {
                    resultMatrix[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        System.out.println("Product of Matrix A and Matrix B:");
        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bCols; j++) {
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}



PROBLEM 3 : 


import java.util.ArrayList;
import java.util.LinkedList;
class Book {
    String title;
    String author;
    int year;
    String genre;

    public Book(String title, String author, int year, String genre) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
    }
    public void info() {
        System.out.println("Title: " + title + ", Author: " + author + ", Year: " + year + ", Genre: " + genre);
    }
}
public class BookCollection {
    public static void main(String[] args) {
        ArrayList<Book> bookListArray = new ArrayList<>();
        
        bookListArray.add(new Book("How to get nobel by hasina", "JOY", 2018, "Fiction"));
        bookListArray.add(new Book("2024", "DEAD", 2024, "Emotional"));
        bookListArray.add(new Book("POWER OF BD STUDENT", "MR UNKNOWN", 2024, "Action"));

     
        System.out.println("books arraylist:");
        for (Book book : bookListArray) {
            book.info();
        }

        bookListArray.remove(1);
        
        System.out.println("\nbooks arraylist after removal:");
        for (Book book : bookListArray) {
            book.info();
        }
        
        LinkedList<Book> bookListLinked = new LinkedList<>(bookListArray);

        bookListLinked.add(new Book("BD LADY HASINA", "Sheikh Mujib", 1971, "thriller"));
        bookListLinked.add(new Book("FIFA OF AWAMI LEAGUE", "Kawwa KAder", 2009, "funny"));

        System.out.println("\nbooks linkedList:");
        for (Book book : bookListLinked) {
            book.info();
        }
        
        bookListLinked.remove(0);

        System.out.println("\nbooks linkedList after removal:");
        for (Book book : bookListLinked) {
            book.info();
        }
    }
}



PRACTICE PROBLEM 1 BYE LAB 3: 

  
import java.util.Scanner;
public class BookProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Book[] books = new Book[3];

        for (int i = 0; i < books.length; i++) {
            System.out.println("Enter details for Book " + (i + 1) + ":");
            books[i] = createBook(sc);
        }

        System.out.println("\nBook Details:");
        for (int i = 0; i < books.length; i++) {
            System.out.println("Book " + (i + 1) + ":");
            books[i].displayDetails();
        }

        Book.displayTotalBooks();
    }
    public static Book createBook(Scanner sc) {
        System.out.print("Title: ");
        String title = sc.next();

        System.out.print("Author: ");
        String author = sc.next();

        System.out.print("Year: ");
        int year = sc.nextInt();
        sc.nextLine();

        return new Book(title, author, year);
    }
}
class Book {
    private String title;
    private String author;
    private int year;
    private static String genre = "Fiction";
    private static int totalBooks = 0;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        totalBooks++;
    }
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year: " + year);
        System.out.println("Genre: " + genre);
    }
    public static void displayTotalBooks() {
        System.out.println("\nTotal number of books: " + totalBooks);
    }
}



PRACTICE PROBLEM 2 BYE LAB 3:



import java.util.LinkedList;
import java.util.Scanner;

public class StudentDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Student> students = new LinkedList<>();

        System.out.println("Student Details 1:");
        students.add(createStudent(sc));

        System.out.println("\nStudent Details 2:");
        students.add(createStudent(sc));

        System.out.println("\nStudent Details 3:");
        students.add(createStudent(sc));

        System.out.println("\nStudent Details:");
        int i = 1;
        for (Student student : students) {
            System.out.println("Student " + i + ":");
            student.displayDetails();
            System.out.println();
            i++;
        }
        Student.displayTotalStudents();
    }
    public static Student createStudent(Scanner sc) {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Department: ");
        String dpt = sc.nextLine();

        System.out.print("CGPA: ");
        double cgpa = sc.nextDouble();
        sc.nextLine(); 

        return new Student(id, name, dpt, cgpa);
    }
}
class Student {
    private int id;
    private String name;
    private String dpt;
    private double cgpa;
    private static String uni = "Your University Name";
    private static int studentCount = 0;

    public Student(int id, String name, String dpt, double cgpa) {
        this.id = id;
        this.name = name;
        this.dpt = dpt;
        this.cgpa = cgpa;
        studentCount++;
    }
    public void displayDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + dpt);
        System.out.println("CGPA: " + cgpa);
        System.out.println("University: " + uni);
    }
    public static void displayTotalStudents() {
        System.out.println("\nTotal number of students: " + studentCount);
    }
}




  
