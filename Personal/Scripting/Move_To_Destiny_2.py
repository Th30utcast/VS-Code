import os
import shutil

# Define source and destination directories
source_dir = "P:\\YT"
destination_dir = os.path.join(source_dir, "Destiny 2")

# Create destination directory if it doesn't exist
if not os.path.exists(destination_dir):
    os.makedirs(destination_dir)

# Loop through all files in the source directory
for filename in os.listdir(source_dir):
    if filename.endswith(".mp4") and "Bungie.Destiny" in filename:
        source_file = os.path.join(source_dir, filename)
        destination_file = os.path.join(destination_dir, filename)
        shutil.move(source_file, destination_file)
        print(f"Moved: {source_file} -> {destination_file}")

print("All relevant .mp4 files have been moved to the Bungie folder.")
