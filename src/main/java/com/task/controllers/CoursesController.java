package com.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.task.models.Courses;
import com.task.repostories.CoursesRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;






import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CoursesController {

    @Autowired
    private CoursesRepository coursesRepository;

    // Get all courses
    @GetMapping("/getAll")
    public List<Courses> getAllCourses() {
        return coursesRepository.findAll();
    }

    // Get course by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<Courses> getCourseById(@PathVariable Long id) {
        Optional<Courses> course = coursesRepository.findById(id);
        return course.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new course
    @PostMapping("/add")
    public Courses addCourse(@RequestBody Courses course) {
        return coursesRepository.save(course);
    }

    // Update a course
    @PutMapping("/update/{id}")
    public ResponseEntity<Courses> updateCourse(@PathVariable Long id, @RequestBody Courses updatedCourse) {
        Optional<Courses> optionalCourse = coursesRepository.findById(id);
        if (optionalCourse.isPresent()) {
            updatedCourse.setId(id);
            Courses savedCourse = coursesRepository.save(updatedCourse);
            return ResponseEntity.ok(savedCourse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a course
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        Optional<Courses> optionalCourse = coursesRepository.findById(id);
        if (optionalCourse.isPresent()) {
            coursesRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    private String uploadDir="assets\\";

    @PostMapping("/uploadImage/{id}")
    public ResponseEntity<?> uploadImage(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        try {
            Courses course = coursesRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));

            if (file.isEmpty()) {
                return ResponseEntity.badRequest().body("Please upload a file.");
            }

            // Ensure the upload directory exists, create if not
            Path directory = Paths.get(uploadDir);
            if (!Files.exists(directory)) {
                Files.createDirectories(directory);
            }

            // Define the file path to save the image
            String filename = file.getOriginalFilename();
            String filePath = uploadDir + filename;

            // Save the file to the specified path
            Path path = Paths.get(filePath);
            Files.write(path, file.getBytes());

            // Set the image URL for the course
            String imageUrl = "assets " +"\\"+ filename; 
            course.setImageUrl(imageUrl);
            coursesRepository.save(course);

            return ResponseEntity.ok().body("Image uploaded successfully. Image URL: " + imageUrl);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Error uploading image: " + e.getMessage());
        }
    }

    @PostMapping("/removeImage/{id}")
    public ResponseEntity<?> removeImage(@PathVariable Long id) {
        try {
            Courses course = coursesRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));

            String imagePath = course.getImageUrl();

            // Delete the image file from the specified directory
            if (imagePath != null && !imagePath.isEmpty()) {
                Path path = Paths.get(imagePath);
                Files.deleteIfExists(path);
            }

            course.setImageUrl("");
            coursesRepository.save(course);

            return ResponseEntity.ok("Image removed successfully.");
        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Error removing image: " + e.getMessage());
        }
    }
    
}
