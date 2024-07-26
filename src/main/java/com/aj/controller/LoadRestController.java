package com.aj.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aj.entity.Load;
import com.aj.service.LoadService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/load")
@Tag(name = "Load", description = "Load management APIs")
public class LoadRestController {

    @Autowired
    private LoadService loadService;

   
    @PostMapping
    @Operation(summary = "Add a new load", description = "Adds a new load to the system")
    public ResponseEntity<String> addLoad(@RequestBody Load load) {
        // Ensure shipperId is set
        if (load.getShipperId() == null) {
            return ResponseEntity.badRequest().body("ShipperId is required");
        }
        loadService.addLoad(load);
        return ResponseEntity.ok("Load details added successfully");
    }

    @GetMapping
    @Operation(summary = "Get loads by shipper ID", description = "Retrieves all loads associated with a specific shipper ID")
    public List<Load> getLoadsByShipperId(@Parameter(description = "Shipper ID (UUID)") @RequestParam UUID shipperId) {
        return loadService.getLoadsByShipperId(shipperId);
    }

    @GetMapping("/{loadId}")
    @Operation(summary = "Get load by ID", description = "Retrieves a specific load by its ID")
    public Load getLoadById(@Parameter(description = "Load ID") @PathVariable Long loadId) {
        return loadService.getLoadById(loadId);
    }

    @PutMapping("/{loadId}")
    @Operation(summary = "Update load", description = "Updates an existing load")
    public Load updateLoad(@PathVariable Long loadId, 
                           @RequestBody Load loadDetails) {
        // Ensure shipperId is set
        if (loadDetails.getShipperId() == null) {
            throw new IllegalArgumentException("ShipperId is required");
        }
        return loadService.updateLoad(loadId, loadDetails);
    }
    
    

    @DeleteMapping("/{loadId}")
    @Operation(summary = "Delete load", description = "Deletes a load from the system")
    public ResponseEntity<String> deleteLoad(@Parameter(description = "Load ID") @PathVariable Long loadId) {
        loadService.deleteLoad(loadId);
        return ResponseEntity.ok("Load deleted successfully");
    }
}