package com.example.bugtrackerapplicationnew.controller;

import com.example.bugtrackerapplicationnew.exception.ResourceNotFoundException;
import com.example.bugtrackerapplicationnew.model.Bug;
import com.example.bugtrackerapplicationnew.repository.BugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bugs")
public class BugController {

    private final BugRepository bugRepository;

    @Autowired
    public BugController(BugRepository bugRepository) {
        this.bugRepository = bugRepository;
    }

    @GetMapping
    public ResponseEntity<List<Bug>> getAllBugs() {
        List<Bug> bugs = bugRepository.findAll();
        return ResponseEntity.ok(bugs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bug> getBugById(@PathVariable Long id) {
        Bug bug = bugRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bug not found with id: " + id));
        return ResponseEntity.ok(bug);
    }

    @PostMapping
    public ResponseEntity<Bug> createBug(@RequestBody Bug bug) {
        Bug createdBug = bugRepository.save(bug);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBug);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bug> updateBug(@PathVariable Long id, @RequestBody Bug bug) {
        Bug existingBug = bugRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bug not found with id: " + id));

        existingBug.setName(bug.getName());
        existingBug.setProject(bug.getProject());
        existingBug.setStatus(bug.getStatus());
        // Update other fields as needed

        Bug updatedBug = bugRepository.save(existingBug);
        return ResponseEntity.ok(updatedBug);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBug(@PathVariable Long id) {
        Bug bug = bugRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bug not found with id: " + id));

        bugRepository.delete(bug);
        return ResponseEntity.noContent().build();
    }
}
