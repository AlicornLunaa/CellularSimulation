# Cellular Simulation
Spiritual successor to molecule simulator, this time with a grid
Uses LWJGL

### Dev controls
- E spawns electrons at selected
- N spawns neutrons at selected
- P spawns protons at selected
- Space increments the simulation by one step
- M1 selects
- M2 deselects

### Theory:
Once cells are close enough to touch/stop moving, bind them all into a 
molecule and treat them as one cell.

Have each proton try to find at least one side of a neutron to bind to