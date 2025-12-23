import { RadialBar, RadialBarChart, ResponsiveContainer } from 'recharts';

export default function RadialGauge({ data, value, subtitle }) {
  return (
    <div className="gauge-wrap">
      <ResponsiveContainer width="100%" height="100%">
        <RadialBarChart innerRadius="70%" outerRadius="95%" startAngle={200} endAngle={-20} data={data}>
          <defs>
            <linearGradient id="radialGradient" x1="0" y1="0" x2="1" y2="1">
              <stop offset="0%" stopColor="#ff7ad1" />
              <stop offset="100%" stopColor="#5aa3ff" />
            </linearGradient>
          </defs>
          <RadialBar
            minAngle={15}
            background
            clockWise
            dataKey="value"
            cornerRadius={20}
            className="radial-bar"
          />
        </RadialBarChart>
      </ResponsiveContainer>
      <div className="gauge-label">
        <span className="gauge-value">{value}</span>
        <span className="gauge-sub">{subtitle}</span>
      </div>
    </div>
  );
}

