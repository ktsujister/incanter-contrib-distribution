(ns incanter-contrib.distributions
  (:require [incanter.distributions :refer [Distribution]])
  (:import (org.apache.commons.math3.distribution CauchyDistribution
                                                  GammaDistribution
                                                  LevyDistribution
                                                  LogNormalDistribution
                                                  ParetoDistribution
                                                  RealDistribution
                                                  TriangularDistribution
                                                  WeibullDistribution)
           (org.apache.commons.math3.random Well19937c)))

(extend-type RealDistribution
  Distribution
  (pdf [d v] (.density d v))
  (cdf [d v] (.cumulativeProbability d v))
  (draw [d] (.sample d))
  (support [d] [(.getSupportLowerBound d) (.getSupportUpperBound d)])
  (mean [d] (.getNumericalMean d))
  (variance [d] (.getNumericalVariance d)))

;;; already exists in incanter
;; BetaDistribution(double alpha, double beta)
;;; Discrete
;; BinomialDistribution(int trials, double p)

(defn cauchy-distribution
  "Incanter Distribution protocol wrapper for Cauchy distribution(http://en.wikipedia.org/wiki/Cauchy_distribution) implementation in Apache Commons Math."
  ([]
     (CauchyDistribution.))
  ([median scale]
     (CauchyDistribution. median scale)))

;;; already exists in incanter
;; ChiSquaredDistribution(double degreesOfFreedom)
;; ExponentialDistribution(double mean)
;; FDistribution(double numeratorDegreesOfFreedom, double denominatorDegreesOfFreedom)

(defn gamma-distribution
  "Incanter Distribution protocol wrapper for Gamma distribution(http://en.wikipedia.org/wiki/Gamma_distribution) implementation in Apache Commons Math."
  ([shape scale]
     (GammaDistribution. shape scale)))

;;; Discrete
;; GeometricDistribution(double p)
;; HypergeometricDistribution(int populationSize, int numberOfSuccesses, int sampleSize)

(defn levy-distribution
  "Incanter Distribution protocol wrapper for Levy distribution(http://en.wikipedia.org/wiki/L%C3%A9vy_distribution) implementation in Apache Commons Math."
  ([mu c]
     (LevyDistribution. (Well19937c.) mu c)))

(defn log-normal-distribution
  "Incanter Distribution protocol wrapper for Log normal distribution(http://en.wikipedia.org/wiki/Log-normal_distribution) implementation in Apache Commons Math."
  ([]
     (LogNormalDistribution.))
  ([scale shape]
     (LogNormalDistribution. scale shape)))

;;; already exists in incanter
;; NormalDistribution()
;; NormalDistribution(double mean, double sd)

;;; Discrete
;; PascalDistribution(int r, double p)
;; PoissonDistribution(double p)
;; PoissonDistribution(double p, double epsilon)
;; PoissonDistribution(double p, double epsilon, int maxIterations)

(defn pareto-distribution
  "Incanter Distribution protocol wrapper for Pareto distribution(http://en.wikipedia.org/wiki/Pareto_distribution) implementation in Apache Commons Math."
  ([]
     (ParetoDistribution.))
  ([scale shape]
     (ParetoDistribution. scale shape)))
;;; already exists in incanter
;; TDistribution(double degreesOfFreedom)

(defn triangular-distribution
  "Incanter Distribution protocol wrapper for Triangular distribution(http://en.wikipedia.org/wiki/Triangular_distribution) implementation in Apache Commons Math."
  ([lower mode upper]
     (TriangularDistribution. lower mode upper)))

;;; already exists in incanter
;; UniformRealDistribution()
;; UniformRealDistribution(double lower, double upper)

(defn weibull-distribution
  "Incanter Distribution protocol wrapper for Weibull distribution(http://en.wikipedia.org/wiki/Weibull_distribution) implementation in Apache Commons Math."
  ([alpha beta]
     (WeibullDistribution. alpha beta)))
