---
date: 2023-05-10
title: "Building a clojure based video editor and renderer on top of FFMPEG"
slug: "clojure-script-video-editor-ffmpeg"
author: "Mitesh (@oxalorg)"
---

As covid hit, [ITRevolution](https://itrevolution.com/) was faced with the task
of shifting their entire conference (DevOps Enterprise Summit / DOES)
operations online. This included editing over 100 videos per conference, each
with custom operations that needed to be fulfilled. To meet this challenge,
they turned to us to build a bespoke video editor that could handle their
unique needs.

Our solution was a cloud-native video editor frontend that used FFMPEG DSL
behind the scenes. This allowed ITRevolution's team to seamlessly edit and
customize their videos using a pretty interface within the browser itself. 

We worked closely with ITRevolution to understand their specific requirements
and built a video editor that could handle all of their custom operations.

We chose to build a video editor completely in ClojureScript to solve the
following problems:

- Edit multiple videos with customisable templates
    - Certain conference videos all follow a similar style of editing eg: Have
      an opening title, background image, 2 picture-in-picture, switch from
      1-PIP view to 2-PIP view etc.
    - The editor allowed for video projects to configure these settings easily
      and getting out of the way. Then all the team had to do was make the
      right cuts for the content.
    - Once the cuts were made the magic would happen all transparently
- Removing the cut mismatch between ITRevolutions conference team and the video
  editors
    - Having to sit with the video editors, or provide them with a timestamp
      based text file detailing all the cuts needed in the final video was an
      extremely time-consuming and cumbersome process
    - Small changes to the clip cuts needed an exponential effort to change
    - We built an easy interface to add non-linear timelines to make the
      trimming and clipping process extremely intuitive
- Syncing speaker and slide footage
    - Often the conference talks include an accompanying slide / video footage
    - But these recordings are not always in sync
    - We built a nifty UI interface for the conference team members to fix this
      mismatch and sync the footage
    - They could then preview the synced footage together making the content
      clipping process even easier
- On-demand rendering
    - The team sometimes had to make emergency changes to the videos at the end
      moment, sometimes even as close as 12 hours to the event
    - We had beefy and horizontally scalable rendering machines always
      available to take up the load
    - The team could just hit a button and the high quality renders would start

## Hiccup-like FFMPEG DSL

- We leveraged the homoiconicity of Clojure[script] and used something called
  as “hiccup-styled” datastructures.
- These are nothing but lists of lists and maps, you can think of it like a
  tree / simplified XML or HTML
- Each video meant to be edited had a hiccup-like edit-state, comparable to a
  saved Adobe Premiere file. Every time an editor made a frontend edit, we
  saved it in the internal representation of this data structure, which
  contains all the information related to how the video should be edited.
- Interaction with this DSL is done through `.cljc` files, and the code is
  shared between the backend and frontend

## Architechture

![itrev-video-editor-architecture](/assets/imgs/itrevolution-video-editor-clojure-architecture.png)

- DOES - DevOps Enterprise Summit
- Everything coloured is an external service
- Everything in black is deployed & managed by us

## Technology stack

- Clojure for the backend
    - Reitit
    - Integrant
    - Jetty + Ring
    - Jesque
    - Buddy
- Datomic cloud for database
- ClojureScript for the frontend dashboard, rendering jobs status, and the
  video editor
    - Reagent
    - Material UI
    - video.js
- FFMPEG for video editing
- GCP compute instances for hosting the backend and for video rendering worker
  machines
- Redis for enqueing video rendering jobs
- Ansible for deployments

## Have an FFMPEG / Live streaming / Video library need?

Reach out to us at [contact@gaiwan.co](mailto:contact@gaiwan.co)
