(ns incanter-contrib.distributions
  (:require [incanter.distributions :refer [Distribution]])
  (:import (org.apache.commons.math3.distribution CauchyDistribution
                                                  ParetoDistribution
                                                  RealDistribution
                                                  TriangularDistribution)))

(extend-type RealDistribution
  Distribution
  (pdf [d v] (.density d v))
  (cdf [d v] (.cumulativeProbability d v))
  (draw [d] (.sample d))
  (support [d] [(.getSupportLowerBound d) (.getSupportUpperBound d)])
  (mean [d] (.getNumericalMean d))
  (variance [d] (.getNumericalVariance d)))

(defn cauchy-distribution
  ([]
     (CauchyDistribution.))
  ([median scale]
     (CauchyDistribution. median scale)))

(defn pareto-distribution
  ([]
     (ParetoDistribution.))
  ([scale shape]
     (ParetoDistribution. scale shape)))

(defn triangular-distribution
  ([lower mode upper]
     (TriangularDistribution. lower mode upper)))
